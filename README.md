LoginToHome
===========

Android Login to Home application

Actually downloading of the image through internet connection must be written in a Worker Thread or using Async Class.
I successfully tried the above, but there seems to be some error in the reading the Input Stream and hence will
make the Thread or Async exit with error leading to app crash. Hence to avoid that and to atleast show "Hello <username>"
in the Home Screen have not used Thread or Async.
