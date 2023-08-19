# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## v0.2.4 - unreleased

### Added
- Refine the Maven build configuration, using maven-compiler-plugin to build the project instead of Axon.ivy's
project-build-plugin.

### Removed
- Initialization process. The process was used to facilitate the development when using ivy-devtool on Axon.ivy
Designer. We will not support this use case anymore.

## v0.2.3 - 2020-05-02
### Added
- Can get all server properties from Engine API
- Can set server property via Engine API

## v0.2.2 - 2020-04-04
### Added
- CHANGELOG.md to keep track changes.
- Create new PMV to deploy not existed PMV.
- Added response to EngineApi params.

### Changed
- Deploy logic/workflow without restart Axon.ivy Engine.
