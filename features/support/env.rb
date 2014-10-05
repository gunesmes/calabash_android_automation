require 'calabash-android/cucumber'
require 'rspec'

Dir[File.dirname(__FILE__) + '/*.rb'].each {|file| require file }

RSpec.configure do |config|
  config.expect_with :rspec do |c|
    c.syntax = :should
  end
  config.mock_with :rspec do |c|
    c.syntax = :should
  end
end