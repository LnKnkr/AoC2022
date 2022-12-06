setlocal
pushd %~dp0

javac *.java
java Day3

set /p=Hit Enter to Continue
del *.class

popd