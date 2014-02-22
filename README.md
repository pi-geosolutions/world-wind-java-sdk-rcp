The World Wind Java RCP SDK provides a starting point for developing a NASA World Wind-enabled application for an Eclipse RCP-based environment.

:warning: If you are attempting to use World Wind in a Java application, visit the [world-wind-java-sdk](https://github.com/unofficial-nasa/world-wind-java-sdk) project.

# About NASA World Wind
NASA's World Wind SDK provides the ability to display and interact with geographic data.

Visit the official page at: http://worldwind.arc.nasa.gov/java/

NASA Open Source Agreement v1.3

# Getting Started
The repository will provide you with an Eclipse RCP-ready World Wind plugin project for your workspace.

:warning: Additional fragment plugins are required to correctly load JOGL libraries. You can download already prepared fragment plugins from the [world-wind-java-sdk-rcp-fragments](https://github.com/unofficial-nasa/world-wind-java-sdk-rcp-fragments) project.

In your desired plugin, you can take advantage of the World Wind SDK by creating an instance of `WorldWindowGLCanvas` (seen as follows):
```java
...

// Setup AWT container.
Composite embeddedContainer = new Composite(parent, SWT.EMBEDDED);
java.awt.Frame frame = SWT_AWT.new_Frame(embeddedContainer);
java.awt.Panel panel = new java.awt.Panel(new java.awt.BorderLayout());
frame.add(panel);

// Create World Wind canvas and add it to panel.
WorldWindowGLCanvas wwd = new WorldWindowGLCanvas();
wwd.setModel(new BasicModel());
panel.add(wwd, java.awt.BorderLayout.CENTER);

...
```

You can view/download a sample application from the [world-wind-java-sdk-rcp-sample](https://github.com/unofficial-nasa/world-wind-java-sdk-rcp-sample) project.

![](https://raw2.github.com/unofficial-nasa/world-wind-java-sdk/gh-pages/SampleWorldWindImage.png)

# Why Use this Cloned Repository?
 * Eclipse-Ready Project
 > The code is automatically ready to be imported into an Eclipse workspace environment.
 
 * Git-Ready Source
 > The official World Wind repository uses SVN. For groups/individuals who wish to use World Wind in their Git development environments, they can use this repository with a complete commit history without having to import the entire SVN project themselves.

# Deviations from Official Code
The intent of this repository is to minimize any deviation from the official World Wind SVN repository. The clone is based off the [WorldWind module](http://worldwind31.arc.nasa.gov/svn/trunk/WorldWind/) found on the SVN repository. There are two (2) primary branches that exist in this project.

 * worldwind-sdk
 > The default branch of the project. Based off the content from the 'official' branch, the source is altered to add project support for the Eclipse environment, address critical bugs which prevent the code from being used in the Eclipse environment and cleanup unused files (such as unrelated build scripts that are not needed for the Eclipse environment).

 * official
 > Provides an exact copy of the official SVN repository.

# Up-to-Date
One (1) of the primary goals for this project is to ensure the code found in this repository is up-to-date with the SVN repository. Updates from the SVN will be regularly checked and pushed into this project's primary branches. If there is ever a time where changes have not yet been pushed from the SVN repository to the Git repository, feel free to flag the [issue](https://github.com/unofficial-nasa/world-wind-java-sdk/issues).
