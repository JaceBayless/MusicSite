# Spring Boot and Vue Template

This template is for Spring Boot and Vue projects. All Vue code is stored in /client and all Spring Boot code is stored in /server. I have already implemented JWT token authentication for Spring Boot and created login/logout pages in Vue to show usage.

## After Forking
### Vue:
1. Update name in package.json.
2. Run `npm install`.
### Spring Boot:
1. Update group in build.gradle and project name in settings.gradle.
2. Update package from tech.noahgeren.template to what fits your needs.
3. Rename TemplateApplication class.
4. Change the JWT private key in application.properties.
5. Refresh Gradle.

## To Build
1. Uncomment lines 14 - 30 of vue.config.js.
2. Run `npm run build`.
3. Change the profile from dev to prod in application.properties.
4. In eclipse run the `bootWar` gradle task.
5. The result should be ROOT.war in /server/build/libs.

## What's Included
### Vue:
 - Axios, Bootstrap-Vue, JS Cookie, Velocity Animate, Vue Router, Vuex
### Spring Boot:
 - Dev tools, JDBC, JPA, H2 Database, MySQL JDBC Binding, Security, Thymeleaf, Lombok, Auth0 JWT
 
