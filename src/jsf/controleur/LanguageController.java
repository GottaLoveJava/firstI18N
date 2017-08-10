package jsf.controleur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

@ManagedBean(name = "languageController")
@SessionScoped

public class LanguageController {
	private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	private String language = locale.getLanguage();

	public List<SelectItem> getLocales() {
		Iterator<Locale> locales = FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
		List<SelectItem> choices = new ArrayList<>();

		while (locales.hasNext()) {
			Locale l = locales.next();
			choices.add(new SelectItem(l.getLanguage(), l.getDisplayName(locale)));
		}

		return choices;

	}

	public void processMyChange(ValueChangeEvent evt) {
		updateLanguage(evt.getNewValue().toString());
	}

	public String changeLanguage(String language) {
		updateLanguage(language);
		return "";
	}

	public void updateLanguage(String lang) {
		language = lang;
		locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		System.out.println("update " + lang);
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getLanguage() {
		return locale.getLanguage();
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}

// <h:commandButton>