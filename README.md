# HATool

## Tietokannan luonti:
* Kopioi service/src/main/sql/create_database.sql.template ilman .template päätettä ja muokkaa tiedostoon halutessasi kannan nimi, käyttäjätunnus ja salasana
* aja komento `psql postgres -a -U postgres -f service/src/main/sql/create_database.sql`

## Tietokannan hallinta:
* taulujen poisto `psql -U hatool -W -d hatool -a -f src/main/sql/drop_tables.sql`
* taulujen luonti `psql -U hatool -W -d hatool -a -f src/main/sql/create_tables.sql`

## Asetukset:
* Kopioi service/src/main/resources/application_properties.template ilman .template päätettä ja lisää tietokannan tiedot ja api:n portti
