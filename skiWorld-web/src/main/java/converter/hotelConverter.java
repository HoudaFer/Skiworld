package converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import managedBeans.roomService;
import skiworld.persistence.Hotel;

@FacesConverter("hotConv")
public class hotelConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() >= 0) {
            try {
            	roomService room = (roomService) context.getExternalContext().getApplicationMap().get("roomService");
                return room.getHotels().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid hotel."));
            }
        }
        else {
            return null;
        }
    }

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            return String.valueOf(((Hotel) value).getIdHotel() -2);
        }
        else {
            return null;
        }
    }  
}
