def call(map config){
pipeline{
agent any //tools,parameters

stages{
stage ("checkout"){
steps{
git branch: 'config.Branch', credentialsId: 'config.cred', url: 'config.repourl' 
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
