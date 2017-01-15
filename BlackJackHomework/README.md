# Blackjack

## Introduction

The objective of this assignment is to build multi-player Blackjack by
implementing several card-related interfaces, including some abstract
classes. It is also a chance to get your hands dirty working with a
complete Java system: implementation, build, and execution. If you are
not familiar with Blackjack, it is worth taking a look at the
[Wikipedia page](https://en.wikipedia.org/wiki/Blackjack) to
understand its game play. Fortunately, only a basic understanding is
required at this point.

## Implementation

Your job is to implement classes within the `impl` package (directory)
based on interface specifications in the `api` package. By default,
these files are all empty. Please see code in the `api` package for
documentation on the purpose of each interface/abstract class. Code in
these directories should not be altered in any way.

## Java package basics

This project uses the Java packaging system; thus, the first line in
each implementation file should be
```java
  package impl;
```
which informs the build system that this class resides in the `impl`
package. See complete Java files in the other directories for more
examples.

To use other Java libraries, the `import` statement should be
employed:
```java
  import java.util.list;
```
This also goes, however, for the abstract classes and interfaces in
the `api` directory. For example, to use the `Card` class, your
implementation must first import it:
```java
  import api.Card;
```
Notice that the first thing `BlackJackGame` imports is a package
defined in your `impl` directory.

## Class layout

Package | Class | Implements | Extends
---|---|---|---
api | Table | |
    | Hand | Comparable |
    | Card | Comparable |
    | Dealer | |
    | Player | Comparable |
impl | BlackJackTable | | Table
     | BlackJackHand | | Hand
     | BlackJackPlayer | Player |
     | BlackJackDealer | BlackJackPlayer | Dealer

Again, classes in `api` and `test` are provided; classes in `impl` are
what should be implemented for this assignment. Their
definitions---what they extend and implement---should follow this
table exactly.

## Build

Using the Java command line tools directly---as we have done
thusfar---is nice, but for larger projects build systems are
preferable. One well established system is
[Ant](http://ant.apache.org), a project managed by the Apache
Foundation. Ant interprets commands in an XML file to essentially run
the Java command line tools on your behalf. This project comes with a
simple Ant file you can use.

For those using the command line, enter the directory containing the
`build.xml` file and run
```bash
  $> ant compile
```
to compile the code (rather than `javac` directly).

For those using Eclipse, you create a new project in the IDE based on
an Ant file. Select
```
File->New->Project...
```
In the wizard, select
```
Java->Java Project from Existing Ant Buildfile
```
then click Next. Populate the "Ant buildfile" box with the path to the
build file from this homework (use Browse to find it on your
filesystem). If the "Like to the buildfile in the file system" option
is unchecked, a copy of the Java files will be created. From there,
you can "play" the files like normal.

## Run

This project expects the user to specify the number of players. It
does so by parsing the command line arguments (see `BlackJackGame` for
details). Fortunately, Ant takes care of this for you; in order to run
the game, type
```bash
  $> ant play
```
and a game with 5 players is run. See the `build.xml` file for details
on where and how this is specified. As an aside, `play` depends on
`compile`, so by running `play` the code is automatically compiled
first (if compilation fails, execution will not commence).

For those using Eclipse, command line arguments are set in the "Run
Configurations" dialogue:
```
Run->Run Configurations...
```
In the left pane, double-click `Java Application`. From there, a new
dialogue appears; by default it is likely called
"New_configuration". In the "Arguments" tab, there is a large box
called "Program Arguments"---put a numeric value in the box and click
"Apply".
