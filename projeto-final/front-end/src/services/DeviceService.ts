import { AxiosInstance } from './AxiosInstance'
import { CadastroDispositivoType, CategoriaDispositivoType, DispositivoType, TipoDispositivoType } from './types'
import { DispositivosMock } from './__mocks__/DispositivosMock'

export class DeviceService {
  private static readonly axios = AxiosInstance()

  static async getAllDevices (): Promise<DispositivoType[]> {
    try {
      const response = await DeviceService.axios.get<DispositivoType[]>('/dispositivo/')
      // const response = { data: DispositivosMock }
      return response.data
    } catch (error) {
      throw new Error('Erro ao buscar os dispositivos')
    }
  }

  static async getAllCategoryDevices (): Promise<CategoriaDispositivoType[]> {
    try {
      const response = await DeviceService.axios.get<CategoriaDispositivoType[]>('/categoriaDispositivo/')
      return response.data
    } catch (error) {
      throw new Error('Erro ao buscar as categorias dos dispositivos')
    }
  }

  static async getAllTypeDevices (): Promise<TipoDispositivoType[]> {
    try {
      const response = await DeviceService.axios.get<TipoDispositivoType[]>('/tipoDispositivo/')
      return response.data
    } catch (error) {
      throw new Error('Erro ao buscar os tipos de dispositivos')
    }
  }

  static async createDevice (data: CadastroDispositivoType): Promise<void> {
    try {
      await DeviceService.axios.post('/dispositivo/', { ...data })
    } catch (error) {
      throw new Error('Erro ao buscar as categorias dos dispositivos')
    }
  }
}
