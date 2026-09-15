def call(map config){
pipeline{
agent any //tools,parameters
tools {
    maven "${config.maventool}"
}
stages{
stage ("checkout"){
steps{
git branch: 'config.branch', credentialsId: 'config.cred', url: 'config.repourl' 
    }    
}   
stage('Build'{
 steps{
 sh "mvn ${config.mavencommand}"    
 }   
} 
 
}//stages closing
    
} //pipeline closing   
    
}//def closing
    
