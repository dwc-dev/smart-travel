import request from '@/utils/request'

// 查询购票列表
export function listTicket_buy(query) {
  return request({
    url: '/system/ticket_buy/list',
    method: 'get',
    params: query
  })
}

export function getTicketInformation() {
  return request({
    url: '/test/ticket_buy/list',
    method: 'get',
  })
}
