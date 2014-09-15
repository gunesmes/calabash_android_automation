require 'calabash-android/calabash_steps'

Given(/^I go to login page$/) do
	wait_for(180) {element_exists("button id:'submit'")}
end

Then(/^I should see login page$/) do
	query "TextView marked:'Sample Application For Test Automation'"
end

When(/^I enter username as "(.*?)"$/) do |username|
	touch("EditText hint:'username'")
    keyboard_enter_text username
end

When(/^I enter password as "(.*?)"$/) do |password|
	touch("EditText hint:'password'")
	keyboard_enter_text password
end

When(/^I press "(.*?)" button$/) do |button|
	login_button_query =  "android.widget.Button marked:'login'"
	touch(login_button_query)
end

Then(/^I should see error message$/) do
	q = query("TextView id:'message'")
	message = q[0]["text"]
	message.should == 'Username or Password is incorrect!'
end

Then(/^I should see home page$/) do
	q = query("TextView id:'home_message'")
	message = q[0]["text"]
	message.should == 'Welcome to Home Page'
end
