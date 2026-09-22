# boto 3 is a sdk for s3 bucket of aws 
# it is used to access the s3 bucket through python code

#import boto3

# ACCESS_KEY_ID ='AKIAZY65GL3LEKJZZWFD'
# SECRET_ACCESS_KEY = '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'

#create an s3 clint

# s3 = boto3.resource('s3', aws_access_key_id=ACCESS_KEY_ID, aws_secret_access_key=SECRET_ACCESS_KEY)

# get all buckets
# for bucket in s3.buckets.all():
    
#     print(bucket.name)

# how dose this boto3 will know which aws account it should look into
# when u make connect the aws cli configured to my computer, it will directly connect the same account.
# to know which account the aws cli is configured is to know with "ls-/.aws/config" it will create file in hidden files in aws folder.


import boto3
from dotenv import load_dotenv
import os

load_dotenv()

ACCESS_KEY_ID = os.getenv('ACCESS_KEY_ID')
SECRET_ACCESS_KEY = os.getenv('SECRET_ACCESS_KEY')

s3 = boto3.resource('s3', aws_access_key_id=ACCESS_KEY_ID, aws_secret_access_key=SECRET_ACCESS_KEY)

# for bucket in s3.buckets.all():

# print(bucket.name)

BUCKET_NAME = 'course-test-tutedude'

# Create a new bucket
# s3.create_bucket(Bucket=BUCKET_NAME, CreateBucketConfiguration={'LocationConstraint': 'ap-south-1'}

#Delete a bucket

# s3.Bucket(BUCKET_NAME).delete()

# Read a file from the bucketq

# s3.Bucket(BUCKET_NAME).download_file('dotfiles/nvim/init.vim', 'test.txt')