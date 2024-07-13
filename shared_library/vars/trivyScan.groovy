def call(String dockerImage, String dockerImageTag){
  def trivyOuput
  try {
      trivyOuput = sh(script: "trivy image --format template \
                              --template '@/root/html.tpl' \
                              --output 'trivy_report.html' \
                              --severity CRITICAL,HIGH \
                               ${dockerImage}:${dockerImageTag}")
  } catch (Exception e) {
     error "Failed to scan with Trivy: ${e.message}" 
  }
  return trivyOuput
}
