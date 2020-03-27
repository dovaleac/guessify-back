#!/usr/bin/env bash

#create room
curl -X POST 'http://localhost:8080/room?number=1234&password=123' | jq

#add master player
curl -X PATCH 'http://localhost:8080/room/1/master?name=masterMonster' | jq

#create game
curl -X POST 'http://localhost:8080/game?roomId=1&masterId=1' \
    -H 'Content-Type: application/json' \
    -d '{
	"totalRounds": 8,
	"cluesPerQuestion": 5,
	"errorsAllowedPerQuestion": 1,
	"scoring": {
		"scorings": "(1,5);(4,2);(3,3);(2,4);(5,1)",
		"malusIfMissed": -1
	}
}' | jq

#add master player
curl -X PATCH 'http://localhost:8080/room/1/player?name=contender1' | jq
curl -X PATCH 'http://localhost:8080/room/1/player?name=contender2' | jq
