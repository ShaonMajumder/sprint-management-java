# Problems solved during project

- ClassNotFoundException: com.mysql.jdbc.Driver -
  https://stackoverflow.com/questions/1585811/classnotfoundexception-com-mysql-jdbc-driver

- add external jars to intellij -
  https://www.jetbrains.com/help/idea/working-with-module-dependencies.html

- adding maven to existing project in intellij -
    https://www.youtube.com/watch?v=M0ixTVUxrUo
    https://www.jetbrains.com/help/idea/convert-a-regular-project-into-a-maven-project.html

- Auto Reload Maven -
    https://www.jetbrains.com/help/idea/delegate-build-and-run-actions-to-maven.html#auto_reload_maven

- Installing Plugins -
    https://www.jetbrains.com/help/idea/managing-plugins.html

- unable to locate entity descriptor hibernate / Unable to locate Persistence
  https://howtodoinjava.com/hibernate/unable-to-locate-persister-error/

- remote: Permission to ShaonMajumder/sprint-management-java.git denied to user
    - https://stackoverflow.com/questions/47465644/github-remote-permission-denied
        - git config user.name "Shaon Majumder"
        - git config credential.username "ShaonMajumder"
        - git config user.email "smazoomder@gmail.com"
        - git config credential.helper store
        - git config -e
        - git config credential.useHttpPath true
        - git push origin master

-  error: update_ref failed for ref 'refs/remotes/origin/master': cannot update the ref 'refs/remotes/origin/master': unable to append to '.git/logs/refs/remotes/origin/master': Permission denied. Everything up-to-date
    - https://stackoverflow.com/questions/2642836/git-error-unable-to-append-to-git-logs-refs-remotes-origin-master-permission
    - sudo chown -R "${USER:-$(id -un)}" .
    - git push origin master

- How to change owner of folder to current user recursively?
    - https://askubuntu.com/questions/829537/how-to-change-owner-of-folder-to-current-user-recursively
    - sudo find ~ -type d -user root -exec sudo chown -R $USER: {} +

- Own .git folder to current user -
    - sudo chown -R "${USER:-$(id -un)}" .
