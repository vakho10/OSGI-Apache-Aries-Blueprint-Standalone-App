# OSGI-Apache-Aries-Blueprint-Standalone-Maven-App
Standalone OSGI maven application using Apache Aries Blueprint (both with and without annotations)

## Description
The project uses Apache Aries OSGI bundles (Blueprint mostly) to ease the building process of custom bundles. For simplicity, the project runs in its embedded OSGI container (it uses the eclipse's one). 

`hello-api` exports an interface with one method. `hello-[langauge]` projects are the service implementers of that single method. They register themselves as services using Aries's Blueprint helper bundle (basically all you need to make bundle "**Blueprintish**" is to include XML description file in bundle's `OSGI-INF/blueprint/` folder. 
After all that, you can use those services (again...) using the same XML description and inject them in a class's instance variable and use accordingly. The injection logic is shown in `hello-executor` project. 

As you may have already notices (if you haven't yet), writing blueprint.xml files (or whatever you name those) is exhausting. I show the alternate solution which uses annotations. You get the same blueprint.xml file but you don't waste time writing them. Instead, you annotate your services, beans and etc, and Aries Blueprint Maven plugin takes care of the generation part. I've only included annotations in `hello-russian` and in `hello-executor-annotated` projects. You may get additional information about Aries Blueprint and its maven plugin on [Apache Aries website](http://aries.apache.org).

To build the project run: `mvn package` 

To run the project simply go to `standalone` project and run it's main class from Eclipse IDE (or in any IDE of your choice) and don't foget to change the bundle folder path to yours.
