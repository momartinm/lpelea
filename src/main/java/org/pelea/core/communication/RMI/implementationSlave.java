/************************************************************************
 * Planning and Learning Group PLG,
 * Department of Computer Science,
 * Carlos III de Madrid University, Madrid, Spain
 * http://plg.inf.uc3m.es
 * 
 * Copyright 2012, Mois�s Mart�nez
 *
 * (Questions/bug reports now to be sent to Mois�s Mart�nez)
 *
 * This file is part of Pelea.
 * 
 * Pelea is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * 
 * Pelea is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Pelea.  If not, see <http://www.gnu.org/licenses/>.
 * 
 ************************************************************************/

package org.pelea.core.communication.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.pelea.core.communication.Message;

/**
 * @author Moises Martinez
 * @group PLG Universidad Carlos III
 * @version 1.0
 */

public class implementationSlave extends UnicastRemoteObject implements interfaceSlave {

    private MailBox _buffer; 
    
    public implementationSlave () throws RemoteException 
    {
        this._buffer = new MailBox();
    }

    @Override
    public synchronized void sendMessage(Message msg) throws RemoteException 
    {
        this._buffer.insertMessage(msg);
    }
    
    @Override
    public synchronized Message getMessage() throws RemoteException 
    {
       return this._buffer.getMessage();
    }
    
    public boolean messages()
    {
        return (!this._buffer.empty());
    }

}
