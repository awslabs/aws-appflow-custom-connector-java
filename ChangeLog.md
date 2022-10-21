# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),

## [Unreleased]
## [1.0.7] - 2022-10-21
### Added
- Added support for Entity specific custom properties.

## [1.0.6] - 2022-08-16
### Added
- Basic auth support for OAuth2. We need to add Base64 encoded Basic Auth header while making OAuth2 request in OAuth2 retrieve token scheme.
- Removed ConnectorContext from validate creds request
- Made api version nullable
- Removed api version from connector runtime settings
- Allowed hypen to be present in field names while generating the filter query

## [1.0.5] - 2022-05-27
### Added
- Added OAuth2 enhancements like connector can define the EntityType and MethodType to get the token.
- Added flag to support entity can be used as destination or not.

## [1.0.2] - 2022-03-04
### Added
- Added ErrorCode for ResourceNotFound like AWS SecretManagerARN etc.

## [1.0.1] - 2022-03-01
### Added
- Added ErrorCode for partial write failures.

### Changed
- Updated documentation for `allOrNone` field in WriteDataRequest.
- Updated documentation for `isSuccess` field in WriteDataResponse.