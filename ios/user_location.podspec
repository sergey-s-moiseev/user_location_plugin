#
# To learn more about a Podspec see http://guides.cocoapods.org/syntax/podspec.html
#
Pod::Spec.new do |s|
  s.name             = 'user_location'
  s.version          = '0.0.2'
  s.summary          = 'User location flutter map plugin.'
  s.description      = <<-DESC
Plugin for determine user position for Flutter Map.
                       DESC
  s.homepage         = 'https://github.com/sergey-s-moiseev/user_location_plugin'
  s.license          = { :file => '../LICENSE' }
  s.author           = { 'Your Company' => 'sergey@moses-team.ru' }
  s.source           = { :path => '.' }
  s.source_files = 'Classes/**/*'
  s.public_header_files = 'Classes/**/*.h'
  s.dependency 'Flutter'

  s.ios.deployment_target = '8.0'
  s.swift_version = '5.3' unless s.swift_version
end

