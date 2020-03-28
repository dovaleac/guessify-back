#!/usr/bin/env bash

echo "create room"
curl -s -X POST 'http://localhost:8080/room?number=1234&password=123' | jq

echo "add master player"
curl -s -X PATCH 'http://localhost:8080/room/1/master?name=masterMonster' | jq

echo "create game"
curl -s -X POST 'http://localhost:8080/game?roomId=1&masterId=1&lang=es' \
    -H 'Content-Type: application/json' \
    -d '{
	"totalRounds": 8,
	"cluesPerQuestion": 5,
	"errorsAllowedPerQuestion": 1,
	"scoring": {
		"scorings": "(0,5);(1,2);(2,3);(3,4);(4,1)",
		"malusIfMissed": -1
	}
}' | jq

echo "add contenders"
curl -s -X PATCH 'http://localhost:8080/room/1/player?name=contender1' | jq
curl -s -X PATCH 'http://localhost:8080/room/1/player?name=contender2' | jq

echo "add one question and then others"
curl -s -X PATCH \
  http://localhost:8080/game/1/question \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 2e7412f9-a4a7-4cb9-83c7-cee8ef349e90' \
  -H 'cache-control: no-cache' \
  -d '{
	"clues": [
		"Una de las personalidades más interesantes (aunque tiene menos fama de la que merecería) del siglo XII europeo",
		"Reinó en 2 de los más famosos países medievales",
		"Una de las mujeres más importantes de la Edad Media",
		"Protagonizó una especie de divorcio con el rey francés y se casó con el heredero británico",
		"Cuando su padre murió haciendo el camino de Santiago, ella se convirtió en duquesa de Aquitania"
	],
	"answer": "Leonor de Aquitania",
	"funFacts": "Aquitania en ese momento era mayor que Francia",
	"difficulty": 5
}' | jq

curl -s -X PATCH \
  http://localhost:8080/game/1/questions \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: f0a999b4-0710-4f3a-95de-457dcec82890' \
  -H 'cache-control: no-cache' \
  -d '[
	{
		"clues": [
			"Nació, y vivió, en un ambiente de continuas traiciones familiares",
			"Se le asocian rumores de un amor prohibido con un rey",
			"Pasó una parte de su vida en prisión, y su liberación fue muy costosa",
			"Participó, con relativo éxito, en las cruzadas",
			"Es más conocido por su apodo que por su nombre de rey, Ricardo I"
		],
		"answer": "Ricardo Corazón de León",
		"funFacts": "Su supuesto amante era el rey de Francia, hasta que lo dejaron y el francés no lo aceptó bien. El emperador del SIR lo encarceló y su madre Leonor de Aquitania consiguió el dinero para el rescate",
		"difficulty": 4
	},
	{
		"clues": [
			"Todo el mundo las quería",
			"Hoy en día, quien las domina bien puede hacer una buena pasta",
			"Fueron importantes en la expansión del Islam por una zona del mundo",
			"Fueron causa más o menos directa del Renacimiento y del descubrimiento de América",
			"La clave de su importancia histórica es que ayudaban a enmascarar el sabor asqueroso de la comida mal conservada."
		],
		"answer": "Las especias",
		"difficulty": 3
	}
]' | jq

echo "start the game"
curl -X PUT \
  http://localhost:8080/game/1/start?roomId=1 \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 72e699d6-c6ec-42a3-acb5-9b07aef537c6' \
  -H 'cache-control: no-cache' -s

echo "try to start the game again -> will fail"
curl -X PUT \
  http://localhost:8080/game/1/start?roomId=1 \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 72e699d6-c6ec-42a3-acb5-9b07aef537c6' \
  -H 'cache-control: no-cache' -s

echo "try to solve"

curl -X PUT \
  'http://localhost:8080/question/1/answer?playerId=2&currentClue=0&answer=Gina%20Lollobrigida' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: ec31dd25-9750-4bd9-9ebf-6623660c2173' \
  -H 'cache-control: no-cache'

echo "reject answer"

curl -X PUT \
  http://localhost:8080/answer/1/reject \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 3cf3af4f-c31f-4830-bdc3-4f15f6548488' \
  -H 'cache-control: no-cache'

echo "ask for clue"

curl -X PUT \
  'http://localhost:8080/question/1/request-clue?playerId=2&currentClue=0' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: c9645df9-2154-4838-9162-2692ad7286ce' \
  -H 'cache-control: no-cache'

echo "ask for clue"

curl -X PUT \
  'http://localhost:8080/question/1/request-clue?playerId=2&currentClue=0' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: c9645df9-2154-4838-9162-2692ad7286ce' \
  -H 'cache-control: no-cache'

echo "give clue"

curl -X PUT \
  'http://localhost:8080/question/1/clue?nextClue=1' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: ed523483-0df1-4dbe-ad75-22f30d1067c2' \
  -H 'cache-control: no-cache'

echo "try to solve"

curl -X PUT \
  'http://localhost:8080/question/1/answer?playerId=2&currentClue=1&answer=John%20McClane' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: ec31dd25-9750-4bd9-9ebf-6623660c2173' \
  -H 'cache-control: no-cache'

echo "reject answer"

curl -X PUT \
  http://localhost:8080/answer/2/reject \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 3cf3af4f-c31f-4830-bdc3-4f15f6548488' \
  -H 'cache-control: no-cache'

echo "give clue"

curl -X PUT \
  'http://localhost:8080/question/1/clue?nextClue=2' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: ed523483-0df1-4dbe-ad75-22f30d1067c2' \
  -H 'cache-control: no-cache'

echo "solve by the other player"

curl -X PUT \
  'http://localhost:8080/question/1/answer?playerId=3&currentClue=1&answer=John%20McClane' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: ec31dd25-9750-4bd9-9ebf-6623660c2173' \
  -H 'cache-control: no-cache'

echo "accept"

curl -X PUT \
  'http://localhost:8080/answer/3/accept?questionInGameId=1&gameId=1&nextQuestionInGameId=2' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: e376d955-7683-4a3d-a1ff-fd44df6b69c8' \
  -H 'cache-control: no-cache'


echo "solve by the first player"

curl -X PUT \
  'http://localhost:8080/question/2/answer?playerId=2&currentClue=0&answer=John%20McClane' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: ec31dd25-9750-4bd9-9ebf-6623660c2173' \
  -H 'cache-control: no-cache'

echo "accept"

curl -X PUT \
  'http://localhost:8080/answer/4/accept?questionInGameId=2&gameId=1&nextQuestionInGameId=3' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: e376d955-7683-4a3d-a1ff-fd44df6b69c8' \
  -H 'cache-control: no-cache'

echo "reveal last question"

