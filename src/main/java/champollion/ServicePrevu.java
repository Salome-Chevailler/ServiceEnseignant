package champollion;

public class ServicePrevu {
	private UE ue;
        private int volumeCM;
        private int volumeTD;
        private int volumeTP;
        
        public ServicePrevu(UE ue, int volumeCM, int volumeTD, int volumeTP){
            this.ue = ue;
            this.volumeCM = volumeCM;
            this.volumeTD = volumeTD;
            this.volumeTP = volumeTP;
        }

        
    public UE getUe() {
        return ue;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }

    public int getVolumeCM() {
        return volumeCM;
    }

    public void setVolumeCM(int volumeCM) {
        this.volumeCM = volumeCM;
    }

    public int getVolumeTD() {
        return volumeTD;
    }

    public void setVolumeTD(int volumeTD) {
        this.volumeTD = volumeTD;
    }

    public int getVolumeTP() {
        return volumeTP;
    }

    public void setVolumeTP(int volumeTP) {
        this.volumeTP = volumeTP;
    }
        
        

}
