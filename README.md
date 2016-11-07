<img src="https://cdn.rawgit.com/baitisj/StopCode/master/images/naloxone.svg" alt="NaloxoneMan" width="200" height="200" align="right" margin="0px 0px 10px 10px"/>

# StopCode 
FDA Naloxone Challenge, team StopCode


## Build this project

1. Ensure that you have Eclipse and the Google Web Toolkit installed:
   https://developers.google.com/eclipse/docs/download

2. Import the project into your workspace in Eclipse using `File > New > Java Project.`
   Then choose `Create project from existing source`. Additional information is found here:
   https://developers.google.com/eclipse/docs/existingprojects


## Video Concept
https://youtu.be/jZErYW8vp0I

## Overview
The StopCode ConceptStopCode is an interactive application for iPhone, Android, and other platforms that connects people witnessing an overdose with nearby naloxone, epinephrine, and defibrillators, while simultaneously activating emergency medical systems by dialing 911. StopCode goes beyond stopping just overdose:  it is an encompassing kit that provides tools to address anaphylaxis and cardiac arrest.

The app starts by walking the observer through a code situation while simultaneously contacting 911 and locating the nearest business registered with StopCode naloxone.  Thanks to new legislation, drone technology is growing quickly; UAV delivery is the next step.  StopCode is developing a highly visible delivery vehicle that will drop from the air, and land within a few feet of an emergency. Naloxone, epinephrine and an AED -- the StopCode kit -- will arrive before first responders can even reach the scene. The StopCode web application works as a GPS locator to quickly and efficiently deliver the StopCode kit -- saving lives even in challenging rural environments.  As the technology expands, the range and speed of delivery can also expand. These measures will ensure quick and efficient delivery of naloxone and other life saving supplies.

StopCode is versatile and aimed at working well in both an urban and rural setting.  It is especially aimed at cities that struggle with EMS response time due to size, lack of manpower, or traffic congestion.  A recent article suggested that it is faster to get an Uber in some cities than to get to EMS.  Additionally, we are pursuing partnerships with samaritans who wish to participate within the newer driving systems in cities such as Uber or Lyft.

In the first iteration, StopCode will connect businesses that have on-site staff who are trained to recognize and administer naloxone in the event of an overdose. This allows us to target specific locations that have rapid phone response and rescuers who can furnish effective aid. As we integrate UAV delivery services, we will reduce the amount of time to find life-saving antidotes and AEDs -- particularly in rural environments. By saving crucial minutes, we hope to greatly improve health outcomes.

## Architecture and Development

The StopCode prototype is written using the Google Web Toolkit. This allows for rapid development and targeting to both mobile and desktop platforms. The current prototype comprises three elements:

  * Database containing locations of StopCode kits, and associated contact information and hours of the business at the location;
  * Web app that obtains the location of the emergency, transmits a request for assistance to the server software, and automatically calls 911;
  * Server software that resolves the closest naloxone source based on the position of the emergency and the database of locations, and connects the business directly to local EMS dispatch to coordinate provision of naloxone, epinephrine, and AED.

By adopting a quasi-centralized distribution network that contains businesses who actively respond to phone calls, we reduce the complexity of resolving time-to-response issues. Priority is placed on activating EMS. StopCode will manage the interface between the person requesting help through the call made to 911 and will automatically connect the nearest businesses to 911 dispatch to coordinate the delivery of naloxone. This ensures that the individual in the emergent situation can focus on rendering aid with the assistance of EMS dispatch staff while supplemental aid is provided by trained members of the community.

## Team StopCode

*Jeffrey Baitis, MS2* - Montana native with a Bachelor’s degree in Computer Engineering who returned to study medicine in 2013 at Oregon Health and Science University. Ten years of mobile software development (RiffWare LLC) and small business start-ups

*Carla Graichen, MD* - California native with degrees in both film production and psychology. Six years working in Los Angeles as an assistant director.  She returned to study medicine in 2012 in Oregon with extensive work in addiction care.  At the University of Washington in 2016, she has become a suboxone provider and an advocate for increased addiction medical care.

*Michael von Plato, MS4* - California native with a Bachelor’s degree in mathematics who returned to study medicine in 2013 at Boston University.

*Jason C. Thane* - Montana native with 20+ years of entrepreneurial leadership, software engineering. Co-Founder, General UI (Software company)
