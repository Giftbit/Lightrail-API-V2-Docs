# Lightrail-API-V2-Docs
If you are looking for the official Lightrail documentation please go to https://lightrailapi.docs.apiary.io/#. This repository is for internal Lightrail use and is responsible for generating the API Blueprint file that is hosted by Apiary.

## Updating Documentation
The documentation that is hosted by Apiary is defined by the `apiary.apib` file on master. 

### Updating Apiary
- The file `master.md` is responsible for the overall structure of the document. This is a good place to start to familiarize with the repo.
- The `api-sections` directory contains the reference section of the API. Files within include the output files from `refreshScript.groovy` that are output to the `generated` directory.
- IMPORTANT: Don't update anything in `generated`. This is compiled and will be overwritten.  

### Compiling
```
cd apiary-sources
./compile.sh
```

#### Requirements
1. Use `brew doctor` to ensure your homebrew is up to date. You might also need to update xcode. 
1. Install groovy: `brew install groovy` (or use sdk man)
1. Install python3: `brew install python3`
1. Install jinja2: `pip3 install jinja2`
1. Install pyyaml: `pip3 install pyyaml`

#### Information about Compile.sh
When this script is run it first runs refreshScript.groovy, followed by apiary-sources/release.py.      

##### refreshScript.groovy: endpoint refresh
The refreshScript.groovy which is responsible for making sure the endpoint requests and response are up to date with the API. The refreshScript.groovy script makes the requests defined in the requests.json. It then loads all of the files defined in /endpoints and makes the replacements defined by `{{REQUEST_REPLACEMENT:...}}`. This allows it to replace the request body and response in the endpoint files. It outputs the endpoint files to /apiary-sources/generated/endpoints. 

There is an API key for staging included in the refreshScript.groovy. You do not need to change this. In the event you do, you'll need to create a USD currency in the new staging account before running `compile.sh`.

##### apiary-sources/release.py: compiling the api blueprint file 
Next, `release.py` amalgamates the contents of apiary-sources using jinja2 into the apiary.apib file.   