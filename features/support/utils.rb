# You can write your global funtion to use for general uses
# such adding member to database, deleting comments or etc. 
# You need to require this file in your env.rb as require "support/messafes.rb"
# or you can use following to require every files:
# Dir[File.dirname(__FILE__) + '/*.rb'].each {|file| require file }

def add_user(username, password)
	# since we don't have database configuration, we don't add user
	# instead db, we will use user.txt so you need to add the following
	# user manually: 

	username = "mesut_test"
	password = "12345"
end