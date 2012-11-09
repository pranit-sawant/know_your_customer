package com.api.util;

import net.rim.device.api.servicebook.ServiceBook;
import net.rim.device.api.servicebook.ServiceRecord;
import net.rim.device.api.system.CoverageInfo;
import net.rim.device.api.system.DeviceInfo;
import net.rim.device.api.system.WLANInfo;

public class ConnectionManager {

	/**
	 * Determines what connection type to use and returns the necessary string
	 * to use it.
	 * 
	 * @return A string with the connection info
	 */
	public static String getConnectionString() {
		
		//blackberry-cross-carrier-and-cross-network-http-connection
		
		String connectionString = null;
		boolean USE_MDS_IN_SIMULATOR = true;

		/*
		 *  Simulator behavior is controlled by the USE_MDS_IN_SIMULATOR
		 *  variable.
		 */
		 
		if (DeviceInfo.isSimulator()) {
			
			
			if (USE_MDS_IN_SIMULATOR) { // ;deviceside=false
				connectionString = "";
			} else { // ;deviceside=true
				connectionString = "";
			}
		}

		// Wifi is the preferred transmission method
		else if (WLANInfo.getWLANState() == WLANInfo.WLAN_STATE_CONNECTED) {
			connectionString = ";interface=wifi";			

		}

		// Is the carrier network the only way to connect?
		else if ((CoverageInfo.getCoverageStatus() & CoverageInfo.COVERAGE_DIRECT) == CoverageInfo.COVERAGE_DIRECT) {

			String carrierUid = getCarrierBIBSUid();
			if (carrierUid == null) {
				// Has carrier coverage, but not BIBS. So use the carrier's TCP
				// network
				connectionString = ";deviceside=true";
				// connectionString = "";
				//Dialog.alert("No Uid conStr = "+connectionString);
			} else {
				// otherwise, use the Uid to construct a valid carrier BIBS
				// request
				connectionString = ";deviceside=false;connectionUID="
						+ carrierUid + ";ConnectionType=mds-public";
				// connectionString = "";
				

			}
		}

		// Check for an MDS connection instead (BlackBerry Enterprise Server)
		else if ((CoverageInfo.getCoverageStatus() & CoverageInfo.COVERAGE_MDS) == CoverageInfo.COVERAGE_MDS) {
			connectionString = ";deviceside=false";
			// connectionString = "";
			// Alert.show("MDS coverage found conStr = "+connectionString);

		}

		// If there is no connection available abort to avoid bugging the user
		// unnecssarily.
		else if (CoverageInfo.getCoverageStatus() == CoverageInfo.COVERAGE_NONE) {
			// Alert.show("There is no available connection.");

		}
		else if ((CoverageInfo.getCoverageStatus() & CoverageInfo.COVERAGE_BIS_B) == CoverageInfo.COVERAGE_BIS_B) 
		{ 
			connectionString = ";deviceside=false;ConnectionType=mds-public";
		}

		// In theory, all bases are covered so this shouldn't be reachable.
		else {
			// connectionString = ";deviceside=true";
			connectionString = "";
			// Alert.show("no other options found, assuming device. conStr = "+connectionString);

		}

		return connectionString;
	}

	/**
	 * Looks through the phone's service book for a carrier provided BIBS
	 * network
	 * 
	 * @return The uid used to connect to that network.
	 */
	private static String getCarrierBIBSUid() {
		ServiceRecord[] records = ServiceBook.getSB().getRecords();
		int currentRecord;

		for (currentRecord = 0; currentRecord < records.length; currentRecord++) {
			if (records[currentRecord].getCid().toLowerCase().equals("ippp")) {
				if (records[currentRecord].getName().toLowerCase()
						.indexOf("bibs") >= 0) {
					return records[currentRecord].getUid();
				}
			}
		}

		return null;
	}

}
