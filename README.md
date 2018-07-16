# Lightrail-API-V2-Docs
Welcome to Lightrail's V2 API Docs.

## Updating Documentation
The documentation that is hosted by Apiary is defined by the `apiary.apib` file on master. 

There are two level of compilation that go into creating the apiary.apib. There is refreshScript.groovy which is responsible for making sure the endpoint requests and response are up to date with the API. There is also release.py in /apiary-sources script which is responsible for amalgamating the apiary.apib file.     

### Endpoint refresh script
The refreshScript.groovy script makes the requests defined in the requests.json script. It then loads all of the files defined in /endpoints and makes the replacements defined by `{{REQUEST_REPLACEMENT:...}}`. This allows it to replace the request body and response in the endpoint files. It outputs the endpoint files to /apiary-sources/compiled/endpoints. 

To use refreshScript.groovy:
1. [Sign-up](https://www.lightrailstaging.net/app/#/register) for a new staging account.
1. Generate a new API key. 
1. Pass the API key in as program argument when you run refreshScript.groovy. (If using intelliJ, you can simple right click refreshScript.groovy to run.)

### Compiling api-sources into apiary.apib 

#### You need to have python3.
1. Use `brew doctor` to ensure your homebrew is up to date. I had to update xcode etc.
2. Install python3: `brew install python3`
3. Install jinja2: `pip3 install jinja2`
4. Install pyyaml: `pip3 install pyyaml`

#### Compile:
Navigate to `/apiary-sources` and run:
```
python3 release.py -v metadata.yaml -i master.md -o ../apiary.apib
```