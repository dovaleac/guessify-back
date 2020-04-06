regen:
	psql guessing_game pablogonzalez -a -f src/main/resources/schema.sql
	mvn generate-sources

it:
	psql guessing_game pablogonzalez -a -f src/main/resources/schema.sql
	bash scripts/basic_integration_test.sh

cleandb:
	psql guessing_game pablogonzalez -a -f src/main/resources/schema.sql
