def call(String registeryCredentialId, String dockerImage, String dockerImageTag, String dockerfilePath) {
  def imageName = "${dockerImage}:${dockerImageTag}"
  echo "IMAGE: ${imageName}"
  def buildImage = docker.build(imageName, "-f ${dockerfilePath} .")
  docker.withRegistry('',registeryCredentialId) {
      buildImage.push()
  }
}
