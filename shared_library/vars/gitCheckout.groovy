def call(Map config) {
  echo "URL: ${config.url}"
  echo "BRANCH: ${config.branch}"
  echo "CREDID: ${config.credentialsId}"
  checkout([$class: 'GitSCM',
                            branches: [[name: config.branch ]],
                            doGenerateSubmoduleConfigurations: false,
                            extensions: [],
                            submoduleCfg: [],
                            userRemoteConfigs: [[url: config.url,
                                                credentialsId: config.credentialsId ]]])
}
