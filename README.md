#  lapps-soap-restifier

A sample LAPPS-SOAP restifier webservice

How To Test
===========

You can test this webservice using either "wget" or "curl" along with the input 
provided as part of this project at src/main/webapp/input.json

Run curl for getMetadata():
```bash
curl -H GET http://localhost:8080/soap/getMetadata?endpoint=http://vassar.lappsgrid.org/invoker/anc:stanford.tagger_2.0.0
``` 

Run curl for execute() with input.json:
```bash
curl -H 'content-type: text/json' --data-binary @input.json -X POST http://localhost:8080/soap/execute?endpoint=http://vassar.lappsgrid.org/invoker/anc:stanford.tokenizer_2.0.0
``` 