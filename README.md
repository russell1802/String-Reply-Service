# ReadMe

1. No changes to the environment has been made. 
2. A new endpoint **/v2/reply/{message}** has been added for the new feature. 
3. The http status code uses **HttpStatus** package to get the http code.
4. The rules are made dynamic to accept new addition rules more than 2 in the future. 
5. Add code for rules in the switch if needed in the future. 
6. By default, any code other than clearly defined in the switch will return bad request. 