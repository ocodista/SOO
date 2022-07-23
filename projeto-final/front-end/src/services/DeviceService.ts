import { AxiosInstance } from './AxiosInstance'
import { DispositivoType } from './types'
import { DispositivosMock } from './__mocks__/DispositivosMock'

export class DeviceService {
  private static readonly axios = AxiosInstance()

  static async getAllDevices (): Promise<DispositivoType[]> {
    try {
      // const response = await DeviceService.axios.get<DispositivoType[]>('/dispositivos/')
      const response = { data: DispositivosMock }
      return response.data
    } catch (error) {
      throw new Error('Erro ao buscar as estantes')
    }
  }
}
