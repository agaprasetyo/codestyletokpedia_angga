package id.angga.democodetokopedia.containersearchproduct.activity;

/**
 * Created by Angga.Prasetiyo on 13/08/2015.
 */
public class TextQueryInteractorImpl implements TextQueryInteractor {
    @Override
    public void submitTextQuery(OnFinishSearchListener listener, String query) {
        listener.onQuerySent(query);
    }
}
