import request from '@/utils/request'

export function getProvinceTicketCount() {
  return request({
    url: '/test/data-view/province-ticket-count',
    method: 'get',
  })
}
