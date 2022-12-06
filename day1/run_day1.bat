setlocal
pushd %~dp0

javac *.java
java Day1

set /p=Hit Enter to Continue
del *.class

popd