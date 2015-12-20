package moderbord.huntforcoffee2.Model;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class Resistance {

    private int resPiercing, resCrushing, resCleaving, resFire, resNature, resArcane, resLight, resDark;

    public Resistance() {
        this.resPiercing = 0;
        this.resCrushing = 0;
        this.resCleaving = 0;
        this.resFire = 0;
        this.resNature = 0;
        this.resArcane = 0;
        this.resLight = 0;
        this.resDark = 0;
    }

    public void addResPiercing(int i){
        this.resPiercing += i;
    }

    public void addResCrushing(int i){
        this.resCrushing += i;
    }

    public void addResCleaving(int i){
        this.resCleaving += i;
    }

    public void addResFire(int i){
        this.resFire += i;
    }

    public void addResNature(int i){
        this.resNature += i;
    }

    public void addResArcane(int i){
        this.resArcane += i;
    }

    public void addResLight(int i){
        this.resLight += i;
    }

    public void addResDark(int i){
        this.resDark += i;
    }

    public int getResPiercing() {
        return resPiercing;
    }

    public void setResPiercing(int resPiercing) {
        this.resPiercing = resPiercing;
    }

    public int getResCrushing() {
        return resCrushing;
    }

    public void setResCrushing(int resCrushing) {
        this.resCrushing = resCrushing;
    }

    public int getResCleaving() {
        return resCleaving;
    }

    public void setResCleaving(int resCleaving) {
        this.resCleaving = resCleaving;
    }

    public int getResFire() {
        return resFire;
    }

    public void setResFire(int resFire) {
        this.resFire = resFire;
    }

    public int getResNature() {
        return resNature;
    }

    public void setResNature(int resNature) {
        this.resNature = resNature;
    }

    public int getResArcane() {
        return resArcane;
    }

    public void setResArcane(int resArcane) {
        this.resArcane = resArcane;
    }

    public int getResLight() {
        return resLight;
    }

    public void setResLight(int resLight) {
        this.resLight = resLight;
    }

    public int getResDark() {
        return resDark;
    }

    public void setResDark(int resDark) {
        this.resDark = resDark;
    }
}
