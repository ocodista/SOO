import { Flex, Text } from '@chakra-ui/react'
import { DeviceTable } from '../components/Device/DeviceTable'
import { Header } from '../components/Header'
import { DeviceService } from '../services/DeviceService'
import { DispositivoType } from '../services/types'

type DispositivosProps = {
  dispositivos: DispositivoType[]
}

const Dispositivos = ({ dispositivos }: DispositivosProps) => {
  return (
    <Flex
      gap="5rem"
      padding="2rem"
      height="100%"
      direction="column"
    >
      <Header />
      <Flex
        padding="1rem"
        direction="column"
        alignItems="center"
        gap="2rem"
      >
        {dispositivos
          ? (<DeviceTable dispositivos={dispositivos}/>)
          : (<Text>Não há estantes</Text>)}

      </Flex>
    </Flex>
  )
}

export default Dispositivos

Dispositivos.getInitialProps = async () => {
  const dispositivos = await DeviceService.getAllDevices()

  return { dispositivos }
}
