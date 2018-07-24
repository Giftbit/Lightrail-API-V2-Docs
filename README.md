# Lightrail-API-V2-Docs
If you are looking for the official Lightrail documentation please go to https://lightrailapi.docs.apiary.io/#. This repository is for internal Lightrail use and is responsible for generating the API Blueprint file that is hosted by Apiary.

## Updating Documentation
The documentation that is hosted by Apiary is defined by the `apiary.apib` file on master. 

There are two level of compilation that go into creating the apiary.apib. There is refreshScript.groovy which is responsible for making sure the endpoint requests and response are up to date with the API. There is also release.py in /apiary-sources script which is responsible for amalgamating the apiary.apib file.     

To compile both simply navigate to apiary-sources and run `./compile.sh`. You'll need to have groovy installed along with the requirements for compiling the apiary.apib file (see below). 

### Endpoint refresh script
The refreshScript.groovy script makes the requests defined in the requests.json. It then loads all of the files defined in /endpoints and makes the replacements defined by `{{REQUEST_REPLACEMENT:...}}`. This allows it to replace the request body and response in the endpoint files. It outputs the endpoint files to /apiary-sources/generated/endpoints. 

There is an API key for staging included in the refreshScript.groovy. You should not need to change this. In the event you do, you'll first need to create a USD currency in the new staging account.

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