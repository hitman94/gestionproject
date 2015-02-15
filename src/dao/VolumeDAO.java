package dao;

import livre.Volume;
import utilisateur.User;



public class VolumeDAO  extends AbstractDAO<Volume>{

	public VolumeDAO() {

			super(Volume.class,"volume");
	}
}
