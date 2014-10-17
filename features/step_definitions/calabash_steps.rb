require 'calabash-android/calabash_steps'

#----------------------------------------------------------
#----------------------  GIVEN  ---------------------------
#----------------------------------------------------------

Given(/^I open the application$/) do
	wait_for(180) {element_exists("button id:'submit'")}
end

Given(/^I go to "(.*?)" page$/) do |page_button|
	button_query =  "android.widget.Button marked:'#{page_button}'"
	touch(button_query)
end


#----------------------------------------------------------
#-----------------------  WHEN  ---------------------------
#----------------------------------------------------------

When(/^I press "(.*?)" button$/) do |button|
	button_query =  "android.widget.Button marked:'#{button}'"
	touch(button_query)
end

When(/^I enter "(.*?)" text field as "(.*?)"$/) do |text_field, value|
	touch("EditText hint:'#{text_field}'")
	keyboard_enter_text value
end


#----------------------------------------------------------
#-----------------------  THEN  ---------------------------
#----------------------------------------------------------

Then(/^I should see "(.*?)" page$/) do |page|
	query "TextView marked:'#{Messages.pages[page]}'"
end

Then(/^I should see message as "(.*?)"$/) do |message|
	q = query("TextView id:'message'")
	page_message = q[0]["text"]
	page_message.should == message
end

Then(/^I should see home page$/) do
	q = query("TextView id:'home_message'")
	message = q[0]["text"]
	message.should == 'Welcome to Home Page'
end

