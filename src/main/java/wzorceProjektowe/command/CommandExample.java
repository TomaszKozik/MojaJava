package wzorceProjektowe.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Wzorzec behawioralny, w którym obiekt służy do reprezentowania i enkapsulacji
 *    wszystkich informacji potrzebnych do późniejszego wywołania metody.
 * Informacje obejmują nazwę metody, obiekt będący właścicielem metody oraz wartości parametrów metody
 * Pozwala na przechowywanie list kodu, który jest wykonywany później lub wielokrotnie
 * Klient mówi, że chcę, aby określone polecenie zostało uruchomione,
 *    gdy wywoływana jest funkcja execute() na 1 z tych zamkniętych (ukrytych) obiektów
 * Obiekt zwany Nadajnikiem przenosi to polecenie do innego obiektu zwanego Odbiornikiem, aby wykonać właściwy kod
 * TurnTVOn - DeiceButton - TurnTVON - Television.TurnTVON()
 *
 * Korzyści:
 *   Pozwala stworzyć listę poleceń do późniejszego wykorzystania
 *   Klasa to świetne miejsce do przechowywania procedur, które chcesz wykonać
 *   Możesz przechowywać wiele poleceń w klasie, aby używać ich w kółko
 *   Możesz zaimplementować procedury cofania poprzednich poleceń
 *   Unikasz tworzenia wielu małych klas, które przechowują listy poleceń
 *
 * Źródło: https://www.youtube.com/watch?v=7Pj5kAhVBlg
 */


// Interfejs odbiorników
interface ElectronicDevice {
    public void on();

    public void off();

    public void volumeUp();

    public void volumeDown();
}

// Odbiornik 1: telewizor
class Television implements ElectronicDevice {

    private int volume = 0;

    @Override
    public void on() {
        System.out.println("TV is on");
    }

    @Override
    public void off() {
        System.out.println("TV is off");
    }

    @Override
    public void volumeUp() {
        volume++;
        System.out.println("TV volume is at: " + volume);
    }

    @Override
    public void volumeDown() {
        volume--;
        System.out.println("TV volume is at: " + volume);
    }
}

// Odbiornik 2: radio
class Radio implements ElectronicDevice {

    private int volume = 0;

    @Override
    public void on() {
        System.out.println("Radio is on");
    }

    @Override
    public void off() {
        System.out.println("Radio is off");
    }

    @Override
    public void volumeUp() {
        volume++;
        System.out.println("Radio volume is at: " + volume);
    }

    @Override
    public void volumeDown() {
        volume--;
        System.out.println("Radio volume is at: " + volume);
    }
}



// Interfejs wzorca Command
interface CommandInterface {
    public void execute();

    public void undo();
}

// Obsługa przycisków: START
class TurnOnTV implements CommandInterface {

    ElectronicDevice electronicDevice;

    public TurnOnTV(ElectronicDevice electronicDevice) {
        this.electronicDevice = electronicDevice;
    }

    @Override
    public void execute() {
        electronicDevice.on();
    }

    @Override
    public void undo() {
        electronicDevice.off();
    }
}

class TurnOffTV implements CommandInterface {

    ElectronicDevice electronicDevice;

    public TurnOffTV(ElectronicDevice electronicDevice) {
        this.electronicDevice = electronicDevice;
    }

    @Override
    public void execute() {
        electronicDevice.off();
    }

    @Override
    public void undo() {
        electronicDevice.on();
    }
}

class TurnTVUp implements CommandInterface {

    ElectronicDevice electronicDevice;

    public TurnTVUp(ElectronicDevice electronicDevice) {
        this.electronicDevice = electronicDevice;
    }

    @Override
    public void execute() {
        electronicDevice.volumeUp();
    }

    @Override
    public void undo() {
        electronicDevice.volumeDown();
    }
}

class TurnItAllOff implements CommandInterface {

    List<ElectronicDevice> electronicDeviceList;

    public TurnItAllOff(List<ElectronicDevice> electronicDeviceList) {
        this.electronicDeviceList = electronicDeviceList;
    }

    @Override
    public void execute() {
        for(ElectronicDevice electronicDevice : electronicDeviceList) {
            electronicDevice.off();
        }
    }

    @Override
    public void undo() {
        for (ElectronicDevice electronicDevice: electronicDeviceList) {
            electronicDevice.on();
        }
    }
}
// Obsługa przycisków: KONIEC


class DeviceButton {

    CommandInterface commandInterface;

    public DeviceButton(CommandInterface commandInterface) {
        this.commandInterface = commandInterface;
    }

    public void press() {
        commandInterface.execute();
    }

    public void pressUndo() {
        commandInterface.undo();
    }
}

class TVRemote {
    public static ElectronicDevice getDevice() {
        return new Television();
    }
}

public class CommandExample {

    public static void main(String[] args) {
        ElectronicDevice electronicDevice = TVRemote.getDevice();

        TurnOnTV onCommand = new TurnOnTV(electronicDevice);
        DeviceButton onPressed = new DeviceButton(onCommand);
        onPressed.press();

        TurnOffTV offCommand = new TurnOffTV(electronicDevice);
        onPressed = new DeviceButton(offCommand);
        onPressed.press();

        TurnTVUp upCommand = new TurnTVUp(electronicDevice);
        onPressed = new DeviceButton(upCommand);
        onPressed.press();
        onPressed.press();
        onPressed.press();

        Television television = new Television();
        Radio radio = new Radio();
        List<ElectronicDevice> electronicDeviceList = new ArrayList<>();
        electronicDeviceList.add(television);
        electronicDeviceList.add(radio);
        TurnItAllOff turnItAllOff = new TurnItAllOff(electronicDeviceList);
        DeviceButton turnThemOff = new DeviceButton(turnItAllOff);
        turnThemOff.press();
        turnThemOff.pressUndo();

    }
}

