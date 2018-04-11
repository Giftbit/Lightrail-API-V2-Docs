#!/usr/bin/python

from jinja2 import Environment, FileSystemLoader
import yaml
import sys, getopt

def print_usage():
    print ('test.py -v <variables yaml file> -i <inputfile> -o <outputfile>')


inputfile = ''
outputfile = ''
variablesfile= ''
try:
    # opts, args = getopt.getopt(sys.argv[1:],"hv:i:o:",["variables=","input=","output="])
    opts, args = getopt.getopt(sys.argv[1:],"hv:i:o:")
except getopt.GetoptError:
    print_usage()
    sys.exit(2)
for opt, arg in opts:
    if opt == '-h':
        print_usage()
        sys.exit()
    elif opt in ("-i", "--input"):
        inputfile = arg
    elif opt in ("-o", "--output"):
        outputfile = arg
    elif opt in ("-v", "--variables"):
        variablesfile = arg

if (not inputfile) or (not variablesfile) or (not outputfile):
    print_usage()
    sys.exit(2)

print ("Processing "+inputfile+" based on " + variablesfile+". Writing to "+outputfile+".");

# stream = open("variables.yaml", "r")
stream = open(variablesfile, "r")
data = yaml.load(stream)

env = Environment(loader=FileSystemLoader('./'))
template = env.get_template(inputfile)

result = template.render(data)

file = open(outputfile, "w")
file.write(result)
file.close()