node('linux') {
  stage ('Poll') {
    checkout([
      $class: 'GitSCM', branches: [[name: '*/main']], extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/xorgprotoport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [
      string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/xorgprotoport.git'),
      string(name: 'PORT_DESCRIPTION', value: 'X.Org: Protocol Headers'),
      string(name: 'BUILD_LINE', value: 'STABLE')
    ]
  }
}
