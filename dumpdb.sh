export PGPASSWORD="hatool"
pg_dump -f $(date +"%Y%m%d".dump) -F c -U hatool hatool
