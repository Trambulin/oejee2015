psql -d pcworld -h localhost -p 5432 -U postgres -f clear-tables.sql
psql -d pcworld -h localhost -p 5432 -U postgres -f initial-data.sql
pause