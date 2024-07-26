# Speech Synthesizer

## Overview

This project was created as part of the 'Multimedia' course.
It involves creating a speech synthesizer designed to generate clear and accurate train announcements for arrivals and departures at Warszawa Centralna station. The synthesizer uses a set of predefined recordings and phrases to dynamically construct announcements based on the available station data.

## Data Provided

1. **Stations Data** (`stacje` directory): Contains a list of stations accessible from Warszawa Centralna.
2. **Platform and Track Phrases** (`perony_i_tory` directory): Contains phrases related to platforms and tracks.
3. **Departure and Arrival Expressions** (`do_z_stacji` directory): Contains expressions used to announce train departures and arrivals.

### Platform and Track Layout at Warszawa Centralna

- **Platform 1**: Tracks 7 and 5
- **Platform 2**: Tracks 3 and 1
- **Platform 3**: Tracks 2 and 4
- **Platform 4**: Tracks 6 and 8


## Objective

The synthesizer should use the provided data to dynamically construct announcements based on the train's destination, arrival/departure status, and assigned platform and track.

## Features

- **Dynamic Announcement Generation**: The synthesizer will dynamically generate announcements based on the train's destination and track/platform information.
- **Corpus-Based Synthesis**: Utilizes recorded phrases and expressions to produce natural-sounding speech.
- **Customizable Output**: Allows for modifications and updates to the announcement phrases and platform/track data.

