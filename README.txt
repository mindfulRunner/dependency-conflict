Dependency Conflict Issue.



A has two dependencies: B and C.

B has a dependency: C.

A and B both depend on C but with different version.

A dependends on C.v2

B dependends on C.v1


dependency graph:

    A
    |
    |___ C.v2
    |
    |___ B
         |
         |__ C.v1
        
        
        
        



https://docs.gradle.org/current/userguide/dependency_management.html




Other questions:

    - how to add multiple projects as modules for a project?
    
        - assume, Project a, Project b are already existing
        
        - create a new project called all
        
        - copy / move Project a, b into Project all
        
        - open Project all in IntelliJ
        
        - in Gradle view on the right pane, click on '+' (Link Gradle Project), and search / select build.gradle in Project a
        
        - repeat the same for Project b
        
        
    - how to list all projects with gradle command?
        C:\...\gradle\all>gradlew -q projects
        
        ------------------------------------------------------------
        Root project
        ------------------------------------------------------------
        
        Root project 'all'
        +--- Project ':a'
        +--- Project ':b'
        \--- Project ':c'
        
        
    - how to list dependencies?
        - C:\...\gradle\all>\gradlew a:dependencies
            
        +--- org.mindfulrunner:c:2.0
        \--- org.mindfulrunner:b:1.0-SNAPSHOT
             \--- org.mindfulrunner:c:1.0 -> 2.0
             
        - C:\...\gradle\all>gradlew b:dependencies
            
        compileClasspath - Compile classpath for source set 'main'.
        \--- org.mindfulrunner:c:{strictly 1.0} -> 1.0
            
            
        C:\...\gradle\all>gradlew -q a:dependencyInsight --dependency c --configuration compile
        org.mindfulrunner:c:2.0
           variant "runtime" [
              org.gradle.status          = release (not requested)
              org.gradle.usage           = java-runtime (not requested)
              org.gradle.libraryelements = jar (not requested)
              org.gradle.category        = library (not requested)
           ]
           Selection reasons:
              - By conflict resolution : between versions 2.0 and 1.0

        org.mindfulrunner:c:2.0
        \--- compile

        org.mindfulrunner:c:1.0 -> 2.0
        \--- org.mindfulrunner:b:1.0-SNAPSHOT
             \--- compile

        A web-based, searchable dependency report is available by adding the --scan option.
        C:\...\gradle\all>gradlew -q b:dependencyInsight --dependency c --configuration compile
        org.mindfulrunner:c:1.0
           variant "runtime" [
              org.gradle.status          = release (not requested)
              org.gradle.usage           = java-runtime (not requested)
              org.gradle.libraryelements = jar (not requested)
              org.gradle.category        = library (not requested)
           ]

        org.mindfulrunner:c:{strictly 1.0} -> 1.0
        \--- compile

        A web-based, searchable dependency report is available by adding the --scan option.
        C:\...\gradle\all>
        
        
        
    - what is the gradle command alternative to 'mvn install'?
        - in c/build.gradle
            
            apply plugin: 'maven'
            
            group 'org.mindfulrunner'
            version '1.0'
            //version '2.0'
            
        - in command line
            $c> gradle install
            
        - result:
            - C:\Users\i\.m2\repository\org\mindfulrunner\c\1.0\c-1.0.jar
            - C:\Users\i\.m2\repository\org\mindfulrunner\b\1.0-SNAPSHOT\b-1.0-SNAPSHOT.jar
        
        
    - how to get access to Project B, C from Project A?
        - install B, C (i.e., b, c) as described above
        - add mavenLocal to repositories
        
        repositories {
            mavenCentral()
            mavenLocal()
        }
        
        
