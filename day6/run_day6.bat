setlocal
pushd %~dp0

javac *.java
java Day6

set /p=Hit Enter to Continue
del *.class

popd