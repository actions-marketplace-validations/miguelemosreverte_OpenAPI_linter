// Need to use full name to DockerPlugin, since sbt-native-packager uses the same name for its Docker plugin
enablePlugins(sbtdocker.DockerPlugin, JavaAppPackaging)

docker / dockerfile := {
  val appDir = stage.value
  val targetDir = "/app"

  new Dockerfile {
    from("openjdk:8-jre")
    entryPoint(s"$targetDir/bin/${executableScriptName.value}")
    copy(appDir, targetDir)
    workDir("data")
    //cmdRaw("ls")
  }
}

docker / buildOptions := BuildOptions(cache = false)
