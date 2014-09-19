twu-biblioteca
==============

biblioteca assignment for twu

### Changes
> * use `git` instead of `SVN` as a version control tool.
> * use `gradle` as a building tool.

Instructions to push your code to code.google.com
=================================================
1. Sign into Google Code and create a new project
        Project name: twu-biblioteca-yourname
        Version Control System: subversion
        License: Apache

2. Go to 'Source' tab in your project and you will find instructions to check out your empty repository locally
        [svn checkout https://twu-biblioteca-yourname.googlecode.com/svn/trunk/ twu-biblioteca-yourname --username youremail@gmail.com]

3. Copy all the files/folders [including hidden ones, eg: .idea] from the extracted zip to this directory.

4. Add all the files/folders to subversion and commit it to google code.
    [ $svn add *;     $svn add .idea;     $svn commit -m “Initial commit”; ]

(Dont forget to add the hidden .idea folder, as it will make opening your project in Intellij easier.
Also when committing, you will be asked for a googlecode generated password, see 'Source' tab.)

Instructions to open your code in Intellij
==========================================
1. Go to File -> Open (or Open Project)
2. Select the directory containing the code
DONE !

