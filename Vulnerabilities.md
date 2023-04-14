1. Added allowPublicKeyRetrieval=true
in spring.datasource.url = jdbc:mysql://localhost:3306/sprint_management?allowPublicKeyRetrieval=true&useSSL=false
Due to Connection Java - MySQL : Public Key Retrieval is not allowed
  - java.sql.SQLNonTransientConnectionException: Public Key Retrieval is not allowed - https://stackoverflow.com/questions/50379839/connection-java-mysql-public-key-retrieval-is-not-allowed

2. Check Intellij Warning, to solve absolute libraries.
